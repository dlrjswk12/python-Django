package com.vision.annotation_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.sjw.di.entity.Exam;
import com.sjw.di.entity.ExamList;
import com.sjw.di.entity.NewlecExam;

@ComponentScan({"com.sjw.di.ui"})//({"com.sjw.di.ui"}) //("com.sjw.di.entity")
@Configuration
public class NewlecAppConfig {
	
	// 메소드명은 무관
	@Bean // GridExamConsole 와 InlineExamConsole 에 @Autowired 된곳에서 사용 
	public Exam xxxx() { 
		// NewlecExam 클래스는 @Component가 붙어야 한다.
		return new NewlecExam("김치국",70,80,90,100);
	}
	
	@Bean 
	public ExamList yyyy() {
		// ExamList 클래스는 @Component가 붙어야 한다.
		return new ExamList();
	}
}
