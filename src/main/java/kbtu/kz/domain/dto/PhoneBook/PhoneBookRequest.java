package kbtu.kz.domain.dto.PhoneBook;

import jakarta.persistence.ManyToOne;
import kbtu.kz.domain.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PhoneBookRequest {

    private String name;
    private String phone_number;
    private Date b_day;
    private String organization;
    private Integer user_id;
}
