# problem 5: Queen's Attack II 

## Бодлогын тайлбар

`n x n` хэмжээтэй шатарын талбай дээр хатан хаан байрлана. Тэр `k` ширхэг саадтай. Хатан хаан аль зүг рүү ч чөлөөтэй явж чаддаг (дээш, доош, баруун, зүүн, болон бүх диагональ чиглэлүүд).

Зорилго нь: өгөгдсөн саадууд болон шатрын хязгаар дотор **хатны довтолж чадах нийт нүдний тоог олох**.

---

## Бодлогын холбоос

[Queen's Attack II - HackerRank](https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true)

---

## Нотолгоо ба шийдэл

1. Хатан хаанаас `8 зүгт` хичнээн нүд чөлөөтэй байгаа вэ гэдгийг олно.
2. Эхэндээ хатны хүрч чадах хамгийн алсын зайг тооцоолно (`up`, `down`, `left`, `right`, `diagonals`).
3. Саад бүрийг шалгаж, тэдгээр нь хатны явж чадах зүгт байрлаж байвал тухайн зүгт хүрэх зайг багасгана.
4. Эцэст нь бүх чиглэлийн боломжит алхмуудын нийлбэрийг гаргана.

---

## Жишээ

**Оролт:**
n = 5
k = 3
r_q = 4
c_q = 3
obstacles = [[5, 5], [4, 2], [2, 3]]


**Гаралт:**
10
