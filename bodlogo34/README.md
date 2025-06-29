# Problem 34: Queue using Two Stacks 
## Бодлогын тайлбар

Хоёр стек ашиглан дараалал (queue) бүтцийг хэрэгжүүлэх бодлого. Stack нь LIFO (Last In First Out) зарчмаар ажилладаг бол queue нь FIFO (First In First Out) зарчмаар ажилладаг.

## Оролт

- Эхний мөрөнд `q` (үйлдлийн тоо)
- Дараагийн `q` мөрөнд үйлдлүүд:
  - `1 x`: x утгыг дарааллын ард нэмэх (enqueue)
  - `2`: дарааллын эхний элементийг хасах (dequeue)
  - `3`: дарааллын эхний элементийг хэвлэх (front)

## Гаралт

3-р төрлийн үйлдлийн хариунууд

## Алгоритм

**Хоёр стек ашиглах арга:**

1. Stack1: enqueue үйлдэлд ашиглана
2. Stack2: dequeue, front үйлдэлд ашиглана
3. Stack2 хоосон бол Stack1-ээс бүх элементийг Stack2 руу шилжүүлнэ
4. Цаг хугацааны нарийвчлал: O(1) amortized

## Холбоос

- [HackerRank - Queue using Two Stacks](https://www.hackerrank.com/challenges/queue-using-two-stacks)

## Жишээ

```
Оролт:
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2

Гаралт:
14
14
```