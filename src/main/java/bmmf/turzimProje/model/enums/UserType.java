package bmmf.turzimProje.model.enums;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum UserType {
    ADMIN("ROLE_ADMIN"),
    CLIENT("ROLE_CLIENT");


    private static final Map<String, UserType> lookup = new ConcurrentHashMap<>();

    static {
        Arrays.stream(UserType.values()).forEach(userTypeEnum -> lookup.put(userTypeEnum.getRole(), userTypeEnum));
    }

    @Getter
    @Setter
    private String role;

    UserType(String role) {
        this.role = role;
    }

    public static UserType get(String role) {
        return lookup.get(role);
    }
}
