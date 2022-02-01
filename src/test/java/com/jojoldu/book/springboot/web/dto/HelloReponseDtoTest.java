package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloReponseDtoTest {

    @Test
    public void 룸복_기능_테스트(){
        String name = "test";
        int amout = 1000;

        HelloResponseDto dto = new HelloResponseDto(name,amout);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amout);
    }
}
