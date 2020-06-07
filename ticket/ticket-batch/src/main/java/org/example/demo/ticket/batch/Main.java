package org.example.demo.ticket.batch;


import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.business.manager.factory.contract.ManagerFactory;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Classe Principale de lancement des Batches.
 *
 * @author lgu
 */
public class Main {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);


    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     * @throws TechnicalException sur erreur technique
     */
    public static void main(String[] pArgs) throws TechnicalException {
        
    	ConfigurableApplicationContext appCtx = 
        		new AnnotationConfigApplicationContext("org.example.demo.ticket");
        
    	try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }

            String vTraitementId = pArgs[0];
            
            if ("ExportTicketStatus".equals(vTraitementId)) {
            	
                LOGGER.info("Execution du traitement : ExportTicketStatus");
                ManagerFactory vMgrFct = appCtx.getBean("managerFactory", ManagerFactory.class);
                
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
}
