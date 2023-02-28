package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Data
public class MilestoneBuilder {

    private int id;
    private String name;
    private String references;
    private String description;
    private boolean completed;
}