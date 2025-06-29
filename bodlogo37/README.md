# Problem 37: Game of Two Stacks 
## Бодлогын тайлбар

Хоёр стекээс элементүүдийг авч нийлбэр нь өгөгдсөн утгаас илүүгүй байхаар хамгийн олон элемент авах тоглоом.

## Оролт

- Эхний мөрөнд `g` (тоглоомын тоо)
- Тоглоом бүрт:
  - `n m x` (эхний стекийн хэмжээ, хоёр дахь стекийн хэмжээ, хязгаарлагдсан нийлбэр)
  - Эхний стекийн элементүүд
  - Хоёр дахь стекийн элементүүд

## Гаралт

Тоглоом бүрт авч болох хамгийн олон элементийн тоо

## Алгоритм

**Two Pointers техник:**

1. Эхний стекээс боломжтой хэмжээгээр элемент авна
2. Хоёр дахь стекээс элемент нэмж үзнэ
3. Нийлбэр хэтэрвэл эхний стекээс элемент буцаана
4. Хамгийн их элементийн тоог тэмдэглэнэ
5. Цаг хугацааны нарийвчлал: O(n + m)

## Холбоос

- [HackerRank - Game of Two Stacks](https://www.hackerrank.com/challenges/game-of-two-stacks)

## Жишээ

```
Оролт:
1
5 4 10
4 2 4 6 1
2 1 8 5

Гаралт:
4

Тайлбар: Эхний стекээс [4, 2], хоёр дахь стекээс [2, 1] = 4 элемент
```