# [4조] 토이 프로젝트1 : 여행 여정을 기록과 관리하는 SNS 서비스 1단계

## 🧑‍🤝‍🧑 조원 & 역할

| 이름  | 역할                   |
|-----|----------------------|
| 한상우 | 조장, 여정 도메인 개발, 노션 관리 |
| 구자현 | 설계, 뷰 도메인 개발, git 관리 |
| 박경탁 | 여행 도메인 개발            |
| 심재철 | 여행 도메인 개발            |
| 이민균 | 여정 도메인 개발            |

## 🚀 프로젝트 일정

- 프로젝트 기간: 9월 4일(월) ~ 9월 8일(금)
![img.png](docs/images/schedule.png)

## 🧾 프로젝트 설명

- 여행 및 여정 정보를 콘솔로 입력받아 기록하고 조회할 수 있는 Java 어플리케이션입니다.
- 여행 및 여정 정보는 파일 시스템에 JSON과 CSV로 저장됩니다.
- **3-Layered MVC 패턴**으로 설계했습니다.
- JSON과 CSV 관련 오픈소스 라이브러리를 사용하여 개발했습니다.
- 여행, 여정, 뷰에 대한 테스트 코드를 작성했습니다.

## 🛠️ 개발 환경

- 빌드 관리 도구 : gradle
- 자바 버전: **17**
- 의존성
  - gson
  - opencsv
  - lombok
- 테스트 의존성
  - junit 5 (jupiter)
  - javafaker

## 📐 설계도

![bluprint](docs/images/blueprint.png)

## 📦 패키지 구조

```tree
Main
├── Trip (여행)
│   ├── dao (파일 create, update, read API)
│   ├── dto (인터페이스용 데이터 객체)
│   ├── domain (데이터 객체)
│   ├── service (뷰에 전달할 인터페이스)
│   └── util (CSV 변환에 사용하는 유틸 객체)
├── Itinerary (여정)
│   ├── dao (파일 create, update, read API)
│   ├── dto (인터페이스용 데이터 객체)
│   ├── entity (데이터 객체)
│   ├── exception (예외처리용 객체)
│   ├── type (파일 타입 구분 enum)
│   └── service (뷰에 전달할 인터페이스)
└── controller (뷰)
    └── console (콘솔 뷰 객체)

resources (데이터 파일 저장 경로)
├── Trip
│   ├── json
|   │   └── trip_1.json
│   └── csv
|       └──csv_1.csv
└── Itinerary
    ├── json
    │   └── itineraries_trip_1.json
    └── csv
        └── itineraries_trip_1.csv
```

## 🤝 브랜치 전략

💡 git flow의 일부만 사용했습니다.
- `main` branch
- 기능 추가 시 `feature/기능명` branch 사용
  - 기능들은 `main` branch에 풀 리퀘스트 후 합병
- 버그 수정 시 `bugfix/버그명` branch 사용
  - 수정 후 `main` branch에 풀 리퀘스트 후 합병 
