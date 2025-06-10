# problem 13: Count Accepted Strings by Regex

## Бодлогын тайлбар

Өгөгдсөн регуляр илэрхийлэл (regex) ба урт L-ийн дагуу, зөвхөн 'a' ба 'b' үсгүүдийг агуулсан урт L хэмжээтэй regex-д 

тохирох мөрийн тоог MOD = 10^9+7 тооны модульд харгалзан тооцох.

Оролт:

Эхний мөрөнд q — асуултын тоо (query)

Дараагийн q мөрөнд:

regex (a, b, |, *, (), тэмдэгтүүдтэй)

L — мөрийн урт (integer)

Гаралт:

Тохирох мөрийн тоо (integer) тус бүрийн асуултад тусдаа мөрөнд

## Алгоритм

Regex-ийг NFA болгон хөрвүүлэх (Thompson's construction).

NFA-г DFA болгон хөрвүүлэх subset construction аргаар.

DFA дээр динамик програмчлал ашиглан L уртын мөрийн тоог тооцох.

Уртаас хамаарч DP ашигласан шийдэл (O(L * |DFA|)).

## Холбоос

[Competitive Programming regex to DFA techniques](https://www.hackerrank.com/challenges/count-strings/problem?isFullScreen=true)

Жишээ 

Оролт:

2
a|b 2
ab* 3

Гаралт:

2
3
