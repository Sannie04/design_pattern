// Observable (Subject)
class Observable {
    constructor() {
      this.observers = []; // Mảng chứa các Observer
    }
  
    // Thêm Observer vào danh sách
    addObserver(observer) {
      this.observers.push(observer);
    }
  
    // Xóa Observer khỏi danh sách
    removeObserver(observer) {
      this.observers = this.observers.filter(obs => obs !== observer);
    }
  
    // Thông báo đến tất cả các Observer
    notifyObservers(message) {
      this.observers.forEach(observer => observer.update(message));
    }
  }
  
  // Observer
  class Observer {
    constructor(name) {
      this.name = name;
    }
  
    // Phương thức nhận thông báo từ Observable
    update(message) {
      console.log(`${this.name} received: ${message}`);
    }
  }
  
  // Tạo đối tượng Observable
  const subject = new Observable();
  
  // Tạo các Observer
  const observer1 = new Observer('Observer 1');
  const observer2 = new Observer('Observer 2');
  const observer3 = new Observer('Observer 3');
  
  // Đăng ký các Observer với Observable
  subject.addObserver(observer1);
  subject.addObserver(observer2);
  subject.addObserver(observer3);
  
  // Gửi thông báo tới tất cả Observer
  subject.notifyObservers('The state has changed!');
  //ưu điểm: có thể quản lý các thay đổi trong hệ thống mà không làm thay đổi nhiều mã nguồn.
  // Giảm thiểu sự phụ thuộc giữa các đối tượng, giúp các đối tượng không cần biết đến nhau nhưng vẫn có thể tương tác.
  //Việc thêm hoặc xóa Observer không làm thay đổi Observable.
  

