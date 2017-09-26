#!/bin/bash

__script_name=$(basename "$0")
__script_root=$(readlink -f "$0")
__script_root=$(dirname "${__script_root}")


#-------------------------------------------------------------------------------------------------------------
# Function : usage
#-------------------------------------------------------------------------------------------------------------
function usage {
    cat <<EOF_STR
Objet : Script de lancement du batch d'exportation des status de ticket

Usage :
    ${__script_name} [OPTIONS]

Options :
    -h , --help     : affiche cette aide
    ...
EOF_STR
}



# ============================================================================================================
#   MAIN
# ============================================================================================================

#-------------------------------------------------------------------------------------------------------------
# Script parameters
#-------------------------------------------------------------------------------------------------------------
while [ "_$1" != "_" ]; do
    case $1 in
        -h | --help )   usage
                        exit 0
                        ;;
    esac
    shift
done


#-------------------------------------------------------------------------------------------------------------
# Main program
#-------------------------------------------------------------------------------------------------------------
batch_root=$(dirname "${__script_root}")

# ===== JAVA_HOME
if [ -d "${JAVA_HOME}" -a -x "${JAVA_HOME}/bin/java" ]; then
    java_cmd="$JAVA_HOME/bin/java"
else
    java_cmd=java
fi

# ===== Lancement du batch Java
cd "${batch_root}"
${java_cmd} -Dapplication.home="${batch_root}" -jar lib/ticket-batch*.jar "ExportTicketStatus" $@
