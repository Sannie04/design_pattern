// Sử dụng Immediately Invoked Function Expression (IIFE)
const Singleton = (function () {
    let instance;
  
    function createInstance() {
      return { message: "I am the only instance!" };
    }
  
    return {
      getInstance: function () {
        if (!instance) {
          instance = createInstance();
        }
        return instance;
      },
    };
  })();
  
  const instance1 = Singleton.getInstance();
  const instance2 = Singleton.getInstance();
  
  console.log(instance1 === instance2); 
  // ưu điểm: Đơn giản, dễ hiểu và dễ sử dụng.
  // nhược điểm: Không linh hoạt, không thể thay đổi cách tạo instance.




  
  //Sử dụng ES6 Class
    class SingletonClass {
        constructor() {
        if (SingletonClass.instance) {
            return SingletonClass.instance;
        }
        SingletonClass.instance = this;
        this.message = "I am the only instance!";
        }
    }   
    //uu điểm: Dễ đọc, dễ bảo trì và có thể mở rộng.
    //nhược điểm: Không thể thay đổi cách tạo instance, không hỗ trợ đa luồng.









  //  Sử dụng Object Literal  
  let counter = 0;

const CounterSingleton = {
  getCount: () => counter,
  increment: () => ++counter,
  decrement: () => --counter,
};

Object.freeze(CounterSingleton);

export default CounterSingleton;
// ưu điểm: Đơn giản, không cần tạo class, dễ sử dụng.
// nhược điểm: Không thể mở rộng, không thể thay đổi cách tạo instance.  