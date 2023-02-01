package models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
//@Data - заменяет Getter, Setter, ToString, EqualsAndHashCode, но нужно добавить @NoArgsConstructor
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String name;
    private String references;
    private String description;
    @ToString.Exclude
    private boolean completed;

}