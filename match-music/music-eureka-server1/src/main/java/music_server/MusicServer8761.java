package music_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MusicServer8761 {

	public static void main(String[] args) {
		SpringApplication.run(MusicServer8761.class, args);
	}

}
