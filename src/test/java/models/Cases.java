package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Cases {

    @SerializedName(value = "section_id")
    private int sectionID;

    private String title;

    private String refs;
}
