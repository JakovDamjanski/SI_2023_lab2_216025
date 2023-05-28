# Laboratoriska 2 po Softversko inzenerstvo
## Jakov Damjanski br. index 216025
### CFG graf i cikomatska kompleksnost:

![CFG](CFG.drawio.svg)

### Every branch test sluchai:

1. Test case 1: user = null , userlist = dont_care.
- ovoj test sluchaj ni e namenet za frlanje exception.
2. Test case 2: 
- ovoj test sluchaj ni ima null username i password so space.So cel vleze vo ifot
koj ke mu stavi avtomatski username , i ke vrati false kaj passwordot.
3. Test case 3:
- Niza so 2 validni korisnici, eden od koi ima isti mail i username kako 
momentalniot korisnik(onoj koj ne e vo listata).Ova go pravime so cel vo forot za proverka na
toa dali imame isti username ili email so nekoi od korisnicite da ni vleze vo edniot a da gi skokne ifovite vo drugiot 
sluchaj (za da gi pomine site branchovi).Ovoj test suchaj nema validen password za da izleze od posledniot for.
4. Test case 4: 
- Nevaliden email i kratok password so cel da se pominat i ovie granki.
5. Test case 5:
- Identichen na test case 3 so toa shto ima validen password i so toa go pokriva i T.

| Branch    | Test case 1 | Test case 2 | Test case 3 | Test case 4 | Test case 5 |
|-----------|:-----------:|:-----------:|:-----------:|:-----------:|:-----------:|
| A-B       |      ✓      |             |      ✓      |             |      ✓      |
| A-C       |             |      ✓      |      ✓      |      ✓      |      ✓      | 
| B-V       |      ✓      |             |             |      ✓      |             | 
| C-D       |             |      ✓      |             |             |             |
| C-E,F     |             |             |      ✓      |             |      ✓      |
| D-E,F     |             |      ✓      |             |      ✓      |             |
| E,F-G,H1  |             |      ✓      |      ✓      |             |      ✓      |
| E,F - N   |             |             |             |      ✓      |             |
| G,H1 - H2 |             |      ✓      |      ✓      |             |      ✓      |
| H2 - I,J  |             |             |      ✓      |             |      ✓      |
| H2 - N    |             |      ✓      |      ✓      |             |      ✓      |
| I,J - K   |             |             |      ✓      |             |      ✓      |
| I,J - L   |             |             |      ✓      |             |      ✓      |
| K - L     |             |             |      ✓      |             |      ✓      |
| L - M     |             |             |      ✓      |             |      ✓      |
| L - H3    |             |             |      ✓      |             |      ✓      |
| M - H3    |             |             |      ✓      |             |      ✓      |
| H3 - H2   |             |             |      ✓      |             |      ✓      |
| N - O     |             |      ✓      |      ✓      |             |      ✓      |
| O - Q     |             |      ✓      |      ✓      |             |      ✓      |
| O - P     |             |             |             |      ✓      |             |
| P - V     |             |             |             |      ✓      |             |
| Q - R1    |             |             |      ✓      |             |      ✓      |
| Q - R1    |             |             |      ✓      |             |      ✓      |
| Q - U     |             |      ✓      |             |             |             |
| U -V      |             |      ✓      |      ✓      |             |             |
| R1 - R2   |             |             |      ✓      |             |      ✓      |
| R2 - U    |             |             |      ✓      |             |             |
| R2 - S    |             |             |      ✓      |             |      ✓      |
| S - T     |             |             |             |             |      ✓      |
| T - V     |             |             |             |             |      ✓      |
| S - R3    |             |             |      ✓      |             |      ✓      | 
| R3 - R2   |             |             |      ✓      |             |      ✓      |

### Multiple condition test cases

Za multiple condition kriteriumot za if (user==null || user.getPassword()==null || user.getEmail()==null) imame 4 mozhnosti.
Ova se sluchuva poradi lazy-evaluation.
1. user = null, user.getPassword() = DONTCARE ,user.getEmail()= DONTCARE
2. user != null , user.getPassword() = null , user.getEmail()= DONTCARE
3. user != null , user.getPassword() != null , user.getEmail() = null
4. user != null , user.getPassword() != null , user.getEmail() != null
 Ova se mozhnite sluchaevi za condition kriteriumot (dont care vrednostite se bilo shto).

### Objasnuvanje za unit testovite.

Bidejki imame 5 test sluchai vo everyBranch koristime 5 assert izrazi( + 1 za da proverime dali runtime exceptionot ja ima specifichnata poraka).
Vo unit test codeot soodvetniot test slushaj e numeriran i soodvetstuva so onoj vo tabelata. Tabelata e popolneta koristejki debugger za sekoj od test sluchaevite i belzezhenje na soodvetnite rebra.
1 od ovie test sluchaevi frla exception pa koristime assertThrows,dodeka 4 od ovie test sluchaevi vrajkaat false zaradi toa koristime assert false za sekoj od niv.

Za test sluchaevite od Multiple condition caseot, 3 od niv frlaat exception pa koristime assert throws i assert true za da proverime dali runtime exceptionot go ima ocekuvaniot message. 
Ovaa proverka za poraka ni pomaga za dokolku pri promeni na kodot nekogash dodademe drug runtimeexception so razlichna poraka da mozhe poednostavno da napravime promeni za testiranje na metodot.
Posledniot od ovie test sluchai vrajka false bidejki nema validen password i zaradi toa koristime assert false.


