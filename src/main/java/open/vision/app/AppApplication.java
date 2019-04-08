package open.vision.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import open.vision.app.domain.Answer;
import open.vision.app.domain.AnswerRepository;
import open.vision.app.domain.Question;
import open.vision.app.domain.QuestionRepository;



@SpringBootApplication
public class AppApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner lukkariKysely(QuestionRepository qRepo, AnswerRepository aRepo) {
		return (args) -> {
			log.info("Please tell rosie");

			//Questions
			qRepo.save(new Question("Minä vuonna aloitit opintosi Haaga-Heliassa?"));
			qRepo.save(new Question("Oletko käyttänyt lukkarikonetta?"));
			qRepo.save(new Question("Oletko kokenut lukkarikoneen toimivaksi?"));
			qRepo.save(new Question("Mitä hyvää lukkarikoneessa mielestäsi on?"));
			
			//Answers 
			aRepo.save(new Answer("2019"));
			aRepo.save(new Answer("2018"));
			aRepo.save(new Answer("Aiemmin"));
			
			aRepo.save(new Answer("Kyllä"));
			aRepo.save(new Answer("Ei"));
			aRepo.save(new Answer("En osaa sanoa"));
			
			aRepo.save(new Answer());
			
			
			log.info("Music is my best friend");
			for (Question question : qRepo.findAll()) {
				log.info(question.toString());
			}
		};
	}

}