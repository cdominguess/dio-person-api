package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    COMMERCIAL("Commercial"),
    HOME("Home"),
    MOBILE("Mobile");

    private final String description;
}
