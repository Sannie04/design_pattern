class Observable {
    constructor() {
      this.observers = [];
    }
  
    addObserver(observer) {
      this.observers.push(observer);
    }
  
    removeObserver(observer) {
      this.observers = this.observers.filter(obs => obs !== observer);
    }
  
    notifyObservers(message) {
      this.observers.forEach(observer => observer.update(message));
    }
  }
  
  class Observer {
    constructor(name) {
      this.name = name;
    }
  
    update(message) {
      console.log(`${this.name} received: ${message}`);
    }
  }
  
  // Tạo đối tượng Observable và Observer
  const subject = new Observable();
  const observer1 = new Observer('Observer 1');
  const observer2 = new Observer('Observer 2');
  
  // Đăng ký Observer
  subject.addObserver(observer1);
  subject.addObserver(observer2);
  
  // Gửi thông báo đến Observer
  subject.notifyObservers('State has changed!');
  