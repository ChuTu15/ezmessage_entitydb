package ezcloud.message.booking;


import lombok.Getter;

@Getter
public enum CustomerType {
    CUSTOMER(0),
    STAFF(1),
    GUEST(2);
    private final int value;

    CustomerType(int value) {
        this.value = value;
    }

}
