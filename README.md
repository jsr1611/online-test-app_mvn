# Online Test Application

Online Test

Technical Requirements
1) Models (classes) should be created using OOP principles such as encapsulation, and others. (classlarini OOP conception laridan foydalangan holatda (Encapsulation va hkz) shakllantiring. Dastur bitta admin user bor bolgan holatda ishga tushsin.)
   1) Subject 
   2) Test
   3) Answer 
   4) User 
   5) PayType 
   6) FillBalanceHistory 
   7) UserTestSolveHistory 

2) Dastur ishga tushganda foyudalanuvchida login bo’lish yoki registratsiyadan otish imkoniyati bo’lsin. Agar login bolgan foydalanuvchi admin bolsa unga quyidagi amallarni bajarish imkoni bo’lsin :
   1) Subject CRUD qilish. 
   2) Test CRUD qilish. Bunda testni javoblarini ham CRUD qila olsin
   3) PayType CRUD qilish. (Abiturient balance ini to’ldirayotganda tanlashi uchun CASH  , PayMe , CLICK va hkz)
   4) FillBalance lar tarixini ko’rish barcha PayType lar kesimida.

3) Agar login bolgan yoki registratsiya qilgan foydalanuvchi Abiturient bo’lsa unga quyidagi amallarni bajarish imkoni bo’lsin : (U ham login bo’lganda username va password larni kiritish orqali tizimga kirsin.) 
  
   1) Subject tanlash. Bunda tanlashdan oldin barcha fanlar nomi , testlar soni ,  max ball ,har bir to’g’ri javob uchun beriladigan ball va  fandan test ishlash uchun to’lov summasi haqidagi malumotlar ko’rsatilsin. Subject tanlashi bilanoq balanceda mablag yetarli bo’lsa shu mablagni yechib olsin va shu fandan testlarni ishlash boshlansin. Oxirgi testni ishlashi bilan natijaga subject nomi , max ball , abiturient to’plagan ball ko’rsatilsin.

   2) O’zi tomonidan ishlangan testlari tarixini Subjectlar kesimida ko’ra olsin. Bunda subject nomi , max ball , abiturient to’plagan ball ko’rsatilsin.

   3) Balance ga pul qoshish. Bunda Abiturientga to’lov turini tanlash imkoni berilsin.


## PROGRESS CHECK

- [x] 1) Models (classes) creation

- [x] 2) Services:

    - [x] Registration service
    
    - [x] Continuous service (while loop, sign in, user verification)
    
    - [x] Subject service
  
    - [x] Test service
  
      - [x] Taking tests
    
    - [ ] Payment service
      - [x] Basic payment
      - [ ] Payment converter
      - [ ] Central bank API integration for currency converter
      - [ ] accept payments in any available method that is convenient for the customer
  
- [ ] 3) Database integration
    - [x] Local (txt file)
    - [ ] SQL

    
