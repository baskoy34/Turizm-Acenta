package bmmf.turzimProje.model.dto;

import bmmf.turzimProje.model.enums.TourType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourDto {
    private long id;
    private String startDate;
    private String endDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Long> personels;
    private TourType tourType;
    private String description;
    private String location;
    private int capacity;
    private int price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String personelNames;
}
