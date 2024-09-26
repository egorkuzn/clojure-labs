(ns lab-2.lab21)

(defn lab-21
  "
   Оператор, принимающий функцию `f-t` от одной переменной
   `x`:
   **![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeQeoke3_ONP5ofscgW6IrlyyhmaH9vVnlPJi_aedCHVFoVOzH1yx-oaPQ6QJCkLg_2eQLfhKaZysPP1yRTVZ4vKiUTwcKEC2hC8_tNQKj8FcjuCIY7WG8go0Mh9MSjnX4fsIWKVQMGXoOriPCPTtu8Ou2n?key=MOzn1_bKZhqJBtZnSjyAyg)**
   
   Степень точности задается `h` - шаг интегрирования. По умолчанию берём 0.05.

   Оптимизирована с помощью мемоизации.
   "
  ([f-t x] (lab-21 f-t x 0.05))
  ([f-t x h] 0.5))