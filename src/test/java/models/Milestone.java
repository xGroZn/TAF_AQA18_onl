package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Milestone {

    private int id;

    @Expose
    private String name;

    @SerializedName(value = "refs")
    private String references;

    @Expose
    private String description;

    @SerializedName(value = "is_completed")
    private boolean completed;

    @Expose
    @SerializedName(value = "is_started")
    private boolean started;

}