package ahmed.core.base;

import fr.edf.dco.bhc.contact.AbstractContactRecord;
//import fr.edf.dco.contacts.bhc.entities.contact.EditicRecord;
import fr.edf.dco.feedback.ArmatisFeedBackRecord;
import fr.edf.dco.feedback.AwlFeedBackRecord;
import fr.edf.dco.feedback.EditicRecord;
import fr.edf.dco.feedback.IncaCabestanMmFeedBackRecord;
import fr.edf.dco.feedback.IncaEmissairesMMFeedBackRecord;
import fr.edf.dco.feedback.IncaMMAbandonedRecord;
import fr.edf.dco.targeting.ArmatisDpnrRecord;
import fr.edf.dco.targeting.ArmatisFeaRecord;
import fr.edf.dco.targeting.EcheaApureRecord;
import fr.edf.dco.targeting.EdiwayEdifuzRecord;
import fr.edf.dco.targeting.EtlSimmRecord;
import fr.edf.dco.targeting.IncaAwlMmRecord;
import fr.edf.dco.targeting.IncaCabestanMmRecord;
import fr.edf.dco.targeting.IncaEmissairesMmRecord;
import fr.edf.dco.targeting.IncaInsertRecord;
import fr.edf.dco.targeting.SathoActcoRecord;

public class ContactFactory {

	  public AbstractContactRecord createRecord(String fileName) throws CustomException {
		    if (fileName.contains(Constants.CONTACT_FILE_ETL_SIMM)) {
		      return new EtlSimmRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_ECHEA_APURE)) {
		      return new EcheaApureRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_SATHO_ACTCO)) {
		      return new SathoActcoRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_INCA_CABESTAN_MM)) {
		      return new IncaCabestanMmRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_ARMATIS_DPNR) && fileName.contains("zipfile")) {
		      return new ArmatisDpnrRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_ARMATIS_FEA)) {
		      return new ArmatisFeaRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_INCA_EMISSAIRES_MM)) {
		      return new IncaEmissairesMmRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_INCA_CABESTAN_RETOURS_MM)) {
		      return IncaCabestanMmFeedBackRecord.getRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_ARMATIS_DPNR) && fileName.contains("targzfile")) {
		      return new ArmatisFeedBackRecord(fileName, Constants.CONTACT_STREAM_ARMATIS_DPNR);
		    } else if (fileName.contains(Constants.CONTACT_FILE_ARMATIS_FEA_RETOURS)) {
		      return new ArmatisFeedBackRecord(fileName, Constants.CONTACT_STREAM_ARMATIS_FEA);
		    } else if (fileName.contains(Constants.CONTACT_MESSAGE_EDIFUZ) || fileName.contains(Constants.CONTACT_MESSAGE_EDIWAY)) {
		      return new EdiwayEdifuzRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_ETL_SIMM)) {
		      return AwlFeedBackRecord.getRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_INCA_EMISSAIRES_RETOURS_MM)) {
		      return new IncaEmissairesMMFeedBackRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_AWL_RETOURS) && (fileName.contains(Constants.CONTACT_FILE_AWL_MESSAGES_SENT) || fileName.contains(Constants.CONTACT_FILE_AWL_MESSAGES_RECEIVED) || fileName.contains(Constants.CONTACT_FILE_AWL_NOTIFICATIONS) || fileName.contains(Constants.CONTACT_FILE_AWL_EMAIL_TRACKING))) {
		      return AwlFeedBackRecord.getRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_INCA_ABANDONS_MM)) {
		      return new IncaMMAbandonedRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_EDITIC)) {
		      return EditicRecord.getRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_INCA_INSERT)) {
		      return new IncaInsertRecord(fileName);
		    } else if (fileName.contains(Constants.CONTACT_FILE_INCA_AWL_MM)) {
		      return new IncaAwlMmRecord(fileName);
		    } else {
//		      throw new CustomException("Unknow Contact Type for file : " + fileName, fileName);
		    	return null;
		    }
		  }

}
