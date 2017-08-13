package iristk.app.hotel;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;

import iristk.cfg.SRGSGrammar;
import iristk.furhat.server.Display;
import iristk.furhat.skill.FlowResource;
import iristk.furhat.skill.Skill;
import iristk.furhat.skill.SkillHandler;
import iristk.furhat.skill.TextFileResource;
import iristk.furhat.skill.FormFileResource;
import iristk.furhat.skill.XmlResource;
import iristk.furhat.util.Localizer;
import iristk.furhat.skill.SkillRequirements;
import iristk.speech.OpenVocabularyContext;
import iristk.speech.SemanticGrammarContext;
import iristk.speech.SpeechGrammarContext;
import iristk.system.IrisUtils;
import iristk.util.Language;
import iristk.util.Record;

public class HotelSkill extends Skill  {

	private static final String RECOGNIZER_GRAMMAR = "grammar";
	private static final String RECOGNIZER_OPEN = "open";
	
	private static Logger logger = IrisUtils.getLogger(HotelSkill.class); 
	
	private HotelFlow flow;
	private File propertiesFile;
	private String name = "HotelSkill";
	private Language language = Language.ENGLISH_US;
	private String recognizer = "grammar";
	private List<String> phrases = Arrays.asList("中文","普通话");
	
	public HotelSkill() {
		
		this.propertiesFile = getPackageFile("skill.properties");
		try {
			Record config = Record.fromProperties(propertiesFile);
			name = config.getString("name", name);
			language = new Language(config.getString("language", language.getCode()));
			recognizer = config.getString("recognizer", recognizer);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		//Adds these resources as links in FurhatOS webserver.
		addResource(new TextFileResource(this, "Properties", propertiesFile));
		addResource(new FlowResource(this, "Flow", getSrcFile("HotelFlow.xml")));
		addResource(new XmlResource(this, "Grammar", getPackageFile("HotelGrammar.xml")));
		//Sets up requirements for this class.
		SkillRequirements requirements = getRequirements();
		requirements.setLanguage(language);
		requirements.setSpeechGrammar(recognizer.equals(RECOGNIZER_GRAMMAR));
		requirements.setOpenVocabulary(recognizer.equals(RECOGNIZER_OPEN));
		addEntriesFromFlow(HotelFlow.class, () -> flow);
		
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void init() throws Exception {
		
		SkillHandler handler = getSkillHandler();
		if (recognizer.equals(RECOGNIZER_GRAMMAR))  {
			handler.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(getPackageFile("HotelGrammar.xml"))));
			handler.setDefaultContext("default");
		} else if (recognizer.equals(RECOGNIZER_OPEN)) {
			handler.loadContext("default", new OpenVocabularyContext(language));
			handler.loadContext("default", new SemanticGrammarContext(new SRGSGrammar(getPackageFile("HotelGrammar.xml"))));
// Add the English Contexxt				
			handler.loadContext("English", new OpenVocabularyContext(language));
			handler.loadContext("English", new SemanticGrammarContext(new SRGSGrammar(getPackageFile("HotelGrammar_EN.xml"))));
// Add the Chinese Contexxt			
			handler.loadContext("Chinese", new OpenVocabularyContext(language, phrases));
			handler.loadContext("Chinese", new SemanticGrammarContext(new SRGSGrammar(getPackageFile("HotelGrammar_CN.xml"))));
			
			handler.setDefaultContext("default");
		}
		
		Information information = new Information();
		Weather weather = new Weather();
		flow = new HotelFlow(handler.getSystemAgentFlow(), information, weather);
		
	}

	@Override
	public void stop() throws Exception {
	}
	
	

}
