# Problem 38: Largest Rectangle
## Бодлогын тайлбар

Histogram-д хамгийн том талбайтай тэгш өнцөгтийн талбайг олох бодлого. Өгөгдсөн өндрүүдийг ашиглан хамгийн том тэгш өнцөгтийн талбайг тооцоолно.

## Оролт

- Эхний мөрөнд `n` (баганын тоо)
- Хоёр дахь мөрөнд багана тус бүрийн өндөр

## Гаралт

Хамгийн том тэгш өнцөгтийн талбай

## Алгоритм

**Stack ашиглах арга:**

1. Stack-д индексүүдийг хадгална
2. Одоогийн баганаас өндөр багана stack-д байвал:
   - Pop хийж талбай тооцоолно
   - Хамгийн их талбайг шинэчилнэ
3. Одоогийн индексийг stack-д нэмнэ
4. Цаг хугацааны нарийвчлал: O(n)

## Холбоос

- [HackerRank - Largest Rectangle](https://www.hackerrank.com/challenges/largest-rectangle)

## Жишээ

```
Оролт:
5
1 2 3 4 5

Гаралт:
9

Тайлбар: Өндөр 3, өргөн 3 байх тэгш өнцөгт (талбай = 3 × 3 = 9)
```