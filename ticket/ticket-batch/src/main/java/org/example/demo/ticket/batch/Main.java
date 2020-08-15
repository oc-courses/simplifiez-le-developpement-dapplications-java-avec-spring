package org.example.demo.ticket.batch;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.business.manager.factory.contract.ManagerFactory;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


/**
 * Classe Principale de lancement des Batches.
 *
 * @author lgu
 */
public class Main {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);
    
//    private static ConfigurableApplicationContext appCtx;


    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     * @throws TechnicalException sur erreur technique
     */
    public static void main(String[] pArgs) throws TechnicalException {
        
    	ConfigurableApplicationContext appCtx = 
        		new AnnotationConfigApplicationContext("org.example.demo.ticket");
    	
    	ManagerFactory vMgrFct = appCtx.getBean("managerFactory", ManagerFactory.class);
        FileSystemResource vRes = appCtx.getBean("resourceTicket",FileSystemResource.class);
       
    	try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }

            String vTraitementId = pArgs[0];
            
            if ("ExportTicketStatus".equals(vTraitementId)) {
            	
                LOGGER.info("Execution du traitement : ExportTicketStatus");
                
                // le module batch ne parle qu'avec le module business donc pas
                // d'appel direct d'un DAO !!!
                List<String> statuts = vMgrFct.getTicketManager().getListTicketStatut().stream()
                												   .map(TicketStatut::toString)
                												   .collect(Collectors.toList());
                writeStatut(vRes,statuts);
                               
                LOGGER.info("###### Nom du fichier: "+vRes.getFilename());
                
                
                int beansCnt = appCtx.getBeanDefinitionCount();
                LOGGER.info("Number of Beans: "+beansCnt);
                
                LOGGER.info("The created Beans... ");
                Arrays.asList(appCtx.getBeanDefinitionNames())
                	.forEach(name -> LOGGER.info(name));
                
            } else {
                throw new TechnicalException("Traitement inconnu : " + vTraitementId);
            }
        } catch (Throwable vThrowable) {
            LOGGER.error(vThrowable);
            System.exit(1);
        } finally {
			appCtx.close();
		}
    }

	private static void writeStatut(Resource vRes, List<String> lines) throws IOException {
//		Files.write(Paths.get(vRes.getFilename()).toAbsolutePath(), lines, StandardCharsets.UTF_8);
		Files.write(Paths.get(vRes.getURI()), lines, StandardCharsets.UTF_8);
		LOGGER.info("###### URI: "+vRes.getURI().toString());
		LOGGER.info("###### File-Path: "+Paths.get(vRes.getFilename()).toAbsolutePath().toString());		
	}    
    
}
