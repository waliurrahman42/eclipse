package operation;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import operation.com.dao.entity.Book;
import operation.com.daooperation.BookRepository;

@SpringBootApplication
public class SpringHybernetProjectDatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =	SpringApplication.run(SpringHybernetProjectDatabaseApplication.class, args);
		
		
		BookRepository bookRepository=context.getBean(BookRepository.class);
	
		Book book=new Book();
		book.setBookName("champak");
		book.setPublisher("golden");
		Book b1=bookRepository.save(book);
		System.out.println(b1);
		
		
		//update by id
		Optional<Book> optional=bookRepository.findById(1);
		Book b=optional.get();
		b.setBookName("hulk");
		bookRepository.save(b);
		System.out.println("book details"+b);
	}

}
