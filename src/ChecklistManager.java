import java.util.ArrayList;

public class ChecklistManager {
    private ArrayList<CheckItem> itemList;

    public ChecklistManager() {
        itemList = new ArrayList<>();
    }

    public void addItem(CheckItem item) {
        itemList.add(item);
    }

    public int getTotalCost() {
        int total = 0;

        for (CheckItem item : itemList) {
            total += item.getCost();
        }

        return total;
    }

    public int getCompletedCount() {
        int count = 0;

        for (CheckItem item : itemList) {
            if (item.isCompleted()) {
                count++;
            }
        }

        return count;
    }

    public double getProgressRate() {
        if (itemList.size() == 0) {
            return 0;
        }

        return (double) getCompletedCount() / itemList.size() * 100;
    }

    public boolean updateCompletedStatus(int index, boolean completed) {
        if (index < 0 || index >= itemList.size()) {
            return false;
        }

        itemList.get(index).setCompleted(completed);
        return true;
    }

    public String getChecklistInfo() {
        String result = "";

        result += "[TripCheck 여행 준비 목록]\n\n";

        if (itemList.size() == 0) {
            result += "아직 추가된 준비 항목이 없습니다.\n";
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                result += (i + 1) + ". " + itemList.get(i).getInfo() + "\n";
            }
        }

        result += "\n-----------------------------\n";
        result += "전체 항목 수: " + itemList.size() + "개\n";
        result += "완료 항목 수: " + getCompletedCount() + "개\n";
        result += "총 예상 비용: " + getTotalCost() + "원\n";
        result += "준비 진행률: " + String.format("%.1f", getProgressRate()) + "%\n";

        return result;
    }

    public void clearItems() {
        itemList.clear();
    }
}
