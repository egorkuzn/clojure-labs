# lab-3

- [ ] 3 **Параллельная обработка последовательностей**
	- [ ] 3.1 Реализуйте параллельный вариант filter (не обязательно ленивый) с помощью future.  Параллельная обработка должна производиться блоками по заданному числу элементов. Размер  блоков следует вычислять вручную, без использования готовых функций, таких как partition (для  разделения последовательности следует использовать take и drop). Продемонстрируйте прирост  производительности в сравнении с обычным фильтром.
	- [ ] 3.2 Реализуйте ленивый параллельный filter, который должен работать в том числе с бесконечными  потоками. Продемонстрируйте прирост производительности в сравнении с обычным фильтром.

Benchamark result lab-31:

```bash
egorkuznecov@MacBook-Pro-Egor lab-3 % lein test

lein test lab-3.lab31-test
test parallel filter
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
"Elapsed time: 161.199208 msecs"
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
"Elapsed time: 1209.826083 msecs"
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
1
"Elapsed time: 121959.80525 msecs"
"Elapsed time: 12246.540792 msecs"
"Elapsed time: 12292.994209 msecs"
"Elapsed time: 12204.607041 msecs"
"Elapsed time: 12211.84725 msecs"
2
"Elapsed time: 6123.538875 msecs"
"Elapsed time: 6094.269459 msecs"
"Elapsed time: 6136.99275 msecs"
"Elapsed time: 6107.759042 msecs"
4
"Elapsed time: 3055.280417 msecs"
"Elapsed time: 3073.352042 msecs"
"Elapsed time: 3063.857584 msecs"
"Elapsed time: 3073.280792 msecs"
8
"Elapsed time: 1517.722833 msecs"
"Elapsed time: 1511.858542 msecs"
"Elapsed time: 1521.000041 msecs"
"Elapsed time: 1503.177125 msecs"
14
"Elapsed time: 878.401625 msecs"
"Elapsed time: 875.693709 msecs"
"Elapsed time: 869.40525 msecs"
"Elapsed time: 869.953125 msecs"
non-parallel filter
"Elapsed time: 12256.2235 msecs"
"Elapsed time: 12216.463667 msecs"
"Elapsed time: 122127.57875 msecs"
"Elapsed time: 12238.421375 msecs"
"Elapsed time: 12274.783667 msecs"
```

Benchmark result lab-32:

```bash
egorkuznecov@MacBook-Pro-Egor lab-3 % lein test

lein test lab-3.lab32-test
test parallel filter
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
(0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98)
"Elapsed time: 161.151166 msecs"
1
"Elapsed time: 12024.941791 msecs"
"Elapsed time: 12062.79225 msecs"
"Elapsed time: 12061.98175 msecs"
"Elapsed time: 12084.21225 msecs"
2
"Elapsed time: 6038.935458 msecs"
"Elapsed time: 6003.018583 msecs"
"Elapsed time: 6019.633125 msecs"
"Elapsed time: 5976.601083 msecs"
4
"Elapsed time: 3012.763291 msecs"
"Elapsed time: 2994.497 msecs"
"Elapsed time: 3007.143167 msecs"
"Elapsed time: 3013.965375 msecs"
8
"Elapsed time: 1508.28125 msecs"
"Elapsed time: 1509.750834 msecs"
"Elapsed time: 1495.419042 msecs"
"Elapsed time: 1512.066291 msecs"
14
"Elapsed time: 862.528625 msecs"
"Elapsed time: 866.097792 msecs"
"Elapsed time: 870.184708 msecs"
"Elapsed time: 875.250125 msecs"
non-parallel filter
"Elapsed time: 12058.326792 msecs"
"Elapsed time: 12071.293375 msecs"
"Elapsed time: 12049.087083 msecs"
"Elapsed time: 11962.334416 msecs"

Ran 1 tests containing 0 assertions.
0 failures, 0 errors.
```