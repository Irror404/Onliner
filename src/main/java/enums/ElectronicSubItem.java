package enums;

public enum ElectronicSubItem {
    AUDIO_DEVICE("Aудиотехника"),
    MOBILE_PHONE("Мобильные телефоны и аксессуары");

    private final String item;

    ElectronicSubItem(String item) {
        this.item = item;
    }
    public String getText() {
        return item;
    }
}
