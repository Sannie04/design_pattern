// Eager Initialization (Khởi tạo sớm)
public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
// ưu điểm: Đơn giản, thread-safe, không cần đồng bộ hóa
// nhược điểm: Tốn bộ nhớ ngay cả khi không sử dụng






// Lazy Initialization (Khởi tạo muộn)
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
// ưu điểm: Tiết kiệm bộ nhớ, chỉ khởi tạo khi cần thiết
// nhược điểm: Không an toàn trong môi trường đa luồng, có thể tạo ra nhiều instance nếu không đồng bộ hóa






// Thread-safe Singleton (Đảm bảo an toàn trong môi trường đa luồng)
public class SingletonThreadSafe {
    private static SingletonThreadSafe instance;

    private SingletonThreadSafe() {}

    public static synchronized SingletonThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
}
// ưu điểm: Đảm bảo an toàn trong môi trường đa luồng
// nhược điểm: Tốn thời gian đồng bộ hóa mỗi lần gọi phương thức getInstance(), có thể làm giảm hiệu suất trong môi trường đa luồng





// Double-Checked Locking (Kiểm tra hai lần)
public class SingletonDoubleChecked {
    private static volatile SingletonDoubleChecked instance;

    private SingletonDoubleChecked() {}

    public static SingletonDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleChecked.class) {
                if (instance == null) {
                    instance = new SingletonDoubleChecked();
                }
            }
        }
        return instance;
    }
}
// ưu điểm: Tối ưu hóa hiệu suất trong môi trường đa luồng, chỉ đồng bộ hóa khi cần thiết
// nhược điểm: Phức tạp hơn, cần sử dụng từ khóa volatile để đảm bảo tính nhất quán của biến instance






// Bill Pugh Singleton (Sử dụng lớp tĩnh bên trong)
public class SingletonBillPugh {
    private SingletonBillPugh() {}

    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
// ưu điểm: Đơn giản, thread-safe, hieuu suất tốt hơn so với Double-Checked Locking
// nhược điểm: phuc tạp hơn so với Eager Initialization, nhưng vẫn dễ hiểu và sử dụng




// Enum Singleton (Sử dụng enum để đảm bảo an toàn trong môi trường đa luồng)
public enum SingletonEnum {
    INSTANCE;

    public void someMethod() {
        // Thực hiện một số hành động
    }
}
// ưu điểm: đảm bảo tính duy nhất và an toàn trong môi trường đa luồng, đơn giản và dễ sử dụng
// nhược điểm: Không thể mở rộng, không thể kế thừa từ lớp khác, nhưng có thể sử dụng interface