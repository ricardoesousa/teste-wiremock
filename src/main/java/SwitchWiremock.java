public class SwitchWiremock extends Wiremock {

    public static void escolhaMock(MockType mock) {
        switch (mock) {
            case BASONA:
                getBasona();
                validaBasona();
                break;
            case RELATOS:
                getRelatos();
                validaRelatos();
                break;
        }
    }
}
