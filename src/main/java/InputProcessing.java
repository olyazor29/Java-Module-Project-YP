public class InputProcessing {
    public static void wrongNumberOfPeople() {
        System.out.println("""
                    Введено некорректное значение.
                    Количество гостей должно быть больше 1.
                    Введите новое значение:""");
    }

    public static void wrongPrice() {
        System.out.println("""
                Неверное значение!
                Стоимость товара должна быть представлена в виде положительного числа.
                Введите новое значение стоимости:""");
    }
}
