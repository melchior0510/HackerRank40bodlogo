# Problem 39: Simple Text Editor 
## Бодлогын тайлбар

Дараах үйлдлүүдийг дэмжсэн энгийн текст засварлагч:

1. Текст нэмэх
2. Сүүлээс тэмдэгт устгах
3. Тодорхой байрлал дахь тэмдэгтийг хэвлэх
4. Сүүлийн үйлдлийг буцаах (undo)

## Оролт

- Эхний мөрөнд `Q` (үйлдлийн тоо)
- Дараагийн `Q` мөрөнд үйлдлүүд:
  - `1 W`: мөр W-г нэмэх
  - `2 k`: сүүлээс k тэмдэгт устгах
  - `3 k`: k дэх тэмдэгтийг хэвлэх
  - `4`: сүүлийн үйлдлийг буцаах

## Гаралт

3-р төрлийн үйлдлийн хариунууд

## Алгоритм

**Stack ашиглан түүх хадгалах:**

1. Текстийн өмнөх төлөвүүдийг stack-д хадгална
2. 1, 2 үйлдэл хийхээс өмнө одоогийн текстийг хадгална
3. 4 үйлдэлд stack-аас сүүлийн төлөвийг буцаана
4. Цаг хугацааны нарийвчлал: O(1) per operation

## Холбоос

- [HackerRank - Simple Text Editor](https://www.hackerrank.com/challenges/simple-text-editor)

## Жишээ

```
Оролт:
8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1

Гаралт:
c
y
a
```