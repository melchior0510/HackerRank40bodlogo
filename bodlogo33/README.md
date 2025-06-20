# Problem 33: Kindergarten Adventures 
## Бодлогын тайлбар

Мээра багш цэцэрлэгийн хүүхдүүдээс зурган цуглуулж байна. Хүүхдүүд тойрог ширээний эргэн тойронд суугаад байгаа бөгөөд хүүхэд бүр өөрийн зургаа дуусгахад тодорхой хугацаа шаардлагатай. Мээра тодорхой цэгээс эхлэн цагийн зүүний дагуу зурган цуглуулна.

## Оролт

- Эхний мөрөнд `n` (хүүхдийн тоо)
- Хоёр дахь мөрөнд хүүхэд тус бүрийн шаардлагатай цаг t[i]

## Гаралт

Хамгийн олон хүүхэд зургаа дуусгах боломжтой эхлэх байрлал

## Алгоритм

**Difference Array ашиглах оновчтой арга:**

1. Хүүхэд тус бүрийн хувьд тэр хүүхэд зургаа дуусгах боломжтой эхлэх байрлалуудын хүрээг тодорхойлно
2. Difference array ашиглан range update хийнэ
3. Prefix sum тооцоолж бодит утгуудыг олно
4. Хамгийн их утгатай байрлалыг олно
5. Цаг хугацааны нарийвчлал: O(n)

## Холбоос

- [HackerRank - Kindergarten Adventures](https://www.hackerrank.com/challenges/kindergarten-adventures)

## Жишээ

```
Оролт:
4
1 2 3 4

Гаралт:
3

Тайлбар: 3-р байрлалаас эхлэхэд хамгийн олон хүүхэд зургаа дуусгана
- Хүүхэд 1: 2 цаг (дуусгана)
- Хүүхэд 2: 1 цаг (дуусгана)
- Хүүхэд 3: 0 цаг (аль хэдийн дууссан)
- Хүүхэд 4: 3 цаг (дуусгана)
```