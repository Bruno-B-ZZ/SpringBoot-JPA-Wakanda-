package Projeto_spring.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public String formatLcalDateTime(LocalDateTime ldt){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt);
    }


}