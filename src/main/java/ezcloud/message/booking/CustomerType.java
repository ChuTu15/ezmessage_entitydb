package ezcloud.message.booking;


import lombok.Getter;

@Getter
public enum CustomerType {
    GUEST(0),
    CUSTOMER(1),
    STAFF(2);

    private final int value;

    CustomerType(int value) {
        this.value = value;
    }

}
