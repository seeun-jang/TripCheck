import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ChecklistManager manager = new ChecklistManager();

    public static void main(String[] args) {
        while (true) {
            printMenu();

            int menu = inputInt("메뉴 선택: ");

            if (menu == 1) {
                addItem();
            } else if (menu == 2) {
                showList();
            } else if (menu == 3) {
                updateItemStatus();
            } else if (menu == 4) {
                manager.clearItems();
                System.out.println("\n전체 항목이 삭제되었습니다.\n");
            } else if (menu == 5) {
                System.out.println("\nTripCheck 프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("\n잘못된 메뉴입니다. 다시 선택하세요.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("====================================");
        System.out.println("        TripCheck 여행 준비 관리");
        System.out.println("====================================");
        System.out.println("1. 준비 항목 추가");
        System.out.println("2. 준비 목록 출력");
        System.out.println("3. 완료 여부 수정");
        System.out.println("4. 전체 항목 삭제");
        System.out.println("5. 프로그램 종료");
        System.out.println("====================================");
    }

    private static void addItem() {
        System.out.println("\n[준비 항목 추가]");
        System.out.println("1. 서류");
        System.out.println("2. 짐");
        System.out.println("3. 비용");

        int type = inputInt("항목 종류 선택: ");

        System.out.print("항목 이름 입력: ");
        String name = scanner.nextLine();

        System.out.print("완료 여부 입력(y/n): ");
        String completedInput = scanner.nextLine();

        boolean completed = completedInput.equalsIgnoreCase("y");

        CheckItem item;

        if (type == 1) {
            item = new DocumentItem(name, completed);
        } else if (type == 2) {
            item = new PackingItem(name, completed);
        } else if (type == 3) {
            int cost = inputInt("예상 비용 입력: ");
            item = new MoneyItem(name, completed, cost);
        } else {
            System.out.println("\n잘못된 항목 종류입니다.\n");
            return;
        }

        manager.addItem(item);
        System.out.println("\n항목이 추가되었습니다.\n");
    }

    private static void showList() {
        System.out.println();
        System.out.println(manager.getChecklistInfo());
    }

    private static void updateItemStatus() {
        System.out.println();
        System.out.println(manager.getChecklistInfo());

        int number = inputInt("수정할 항목 번호 입력: ");

        System.out.print("완료 여부 입력(y/n): ");
        String input = scanner.nextLine();

        boolean completed = input.equalsIgnoreCase("y");

        boolean result = manager.updateCompletedStatus(number - 1, completed);

        if (result) {
            System.out.println("\n완료 여부가 수정되었습니다.\n");
        } else {
            System.out.println("\n존재하지 않는 항목 번호입니다.\n");
        }
    }

    private static int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력하세요.");
            }
        }
    }
}
