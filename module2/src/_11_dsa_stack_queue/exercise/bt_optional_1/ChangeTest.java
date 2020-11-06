package _11_dsa_stack_queue.exercise.bt_optional_1;

public class ChangeTest {
    public static void main(String[] args) {
        new ChangeDemicalBinaryHexademical().changeDemicalToBinary(12345);
        System.out.println();
        System.out.println(new ChangeDemicalBinaryHexademical().ChangeBinaryToDemical(1010000101));

        System.out.println("Giá trị thập phân của 7A là: "+new ChangeDemicalBinaryHexademical().ChangeHexaDemicalToDemical("7A"));
    }
}
