# 🎯 넌센스 퀴즈 게임 (Nonsense Quiz Game)

<div align="center">

![메인 화면](https://github.com/ChatHongPT/2024-JAVA-PROJECT/assets/129854575/c2f543f7-8e45-4a7c-a3c3-e3b3062d5a4f)

**실시간 멀티플레이어 넌센스 퀴즈 게임**

*Socket 통신을 활용한 재미있고 도전적인 퀴즈 경험*

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg?style=flat-square)](https://choosealicense.com/licenses/mit/)
[![Java](https://img.shields.io/badge/Java-17+-orange.svg?style=flat-square)](https://www.oracle.com/java/)
[![Status](https://img.shields.io/badge/Status-Active-brightgreen.svg?style=flat-square)]()

</div>

---

## 📋 프로젝트 개요

> **실시간으로 친구들과 함께하는 두뇌 게임!**

여러 플레이어가 동시에 참여하여 창의적이고 재미있는 넌센스 퀴즈를 풀어보세요. Socket 통신 기술을 기반으로 한 매끄럽고 반응성 높은 멀티플레이어 경험을 제공합니다.

### ✨ 주요 특징
- 🌐 **실시간 멀티플레이어** - 최대 8명까지 동시 플레이
- 🎨 **커스터마이징** - 다양한 테마와 설정 옵션
- 🏆 **순위 시스템** - 실시간 랭킹과 통계
- 💬 **채팅 기능** - 게임 중 실시간 소통
- 🎵 **사운드 효과** - 몰입감 있는 배경음악과 효과음

---

## 🛠️ 기술 스택

<div align="center">

### 🎯 Core Technologies
![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Socket.IO](https://img.shields.io/badge/Socket.io-010101?style=for-the-badge&logo=socket.io&logoColor=white)

### 🔧 Development Tools
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

### 🎨 UI Framework
![Swing](https://img.shields.io/badge/Java_Swing-5382A1?style=for-the-badge&logo=java&logoColor=white)

</div>

---

## 👥 개발팀 소개

<div align="center">

| 역할 | 이름 | 담당 업무 |
|:---:|:---:|:---|
| 🎯 **팀장** | **박진용** | 프로젝트 총괄, 아키텍처 설계, 품질 관리 |
| 🔧 **개발자** | **이진규** | 게임 로직, 서버 개발, 네트워크 통신 |
| 🎨 **개발자** | **최홍석** | UI/UX 디자인, 클라이언트 개발, 사용자 경험 |
| 🗄️ **개발자** | **조대인** | 데이터베이스 설계, 서버 최적화, 네트워크 보안 |

</div>

---

## 📊 프로젝트 일정

<div align="center">

### 📅 [상세 WBS 일정표 보기](https://docs.google.com/spreadsheets/d/13AxJwgGNC2VnQWxMEjQ5AIC6CLCdZ66Fd0nFugfy7KM/edit?gid=970999793#gid=970999793)

| 단계 | 기간 | 주요 작업 |
|:---:|:---:|:---|
| **🎯 기획** | Week 1 | 요구사항 분석, 시스템 설계 |
| **💻 개발** | Week 2-4 | 핵심 기능 구현, UI 개발 |
| **🔧 통합** | Week 5 | 시스템 통합, 버그 수정 |
| **✅ 테스트** | Week 6 | 최종 테스트, 성능 최적화 |

</div>

---

## 🎮 주요 기능

### 🏠 메인 화면
```
✨ 게임 시작 - 새로운 게임 세션 생성
⚙️ 옵션 설정 - 개인화된 게임 환경
🏆 순위표 확인 - 실시간 리더보드
❌ 게임 종료 - 안전한 게임 종료
```

### ⚙️ 옵션 설정
<details>
<summary><b>🎨 커스터마이징 옵션</b></summary>

- **🔤 폰트 설정** - 다양한 폰트 스타일 선택
- **📏 폰트 크기** - 가독성 최적화를 위한 크기 조절
- **🖼️ 윈도우 크기** - 화면 해상도에 맞는 크기 설정
- **🎨 색상 테마** - 라이트/다크 모드 및 커스텀 테마
- **🎵 BGM 설정** - 배경음악 볼륨 및 효과음 조절

</details>

### 🏆 순위표
<details>
<summary><b>📊 통계 및 랭킹</b></summary>

- **⚡ 실시간 순위** - 현재 게임 세션 플레이어 순위
- **👑 최고 기록** - 역대 최고 점수 및 달성자
- **📈 승률 통계** - 개인별 게임 승률 및 참여 횟수
- **🎯 평균 점수** - 플레이어별 평균 성과 지표

</details>

### 🎯 게임 화면
<details>
<summary><b>🎮 게임플레이 요소</b></summary>

- **👥 멀티플레이** - 최대 8명 동시 참여
- **⏱️ 타이머 시스템** - 긴장감 있는 시간 제한
- **💯 점수 시스템** - 정확도와 속도 기반 점수 계산
- **💬 실시간 채팅** - 게임 중 플레이어 간 소통
- **🎊 실시간 반응** - 즉각적인 피드백과 애니메이션

</details>

### 🏅 게임 결과
<details>
<summary><b>📋 결과 분석</b></summary>

- **🎯 최종 점수** - 상세한 점수 분석 및 순위
- **🏆 승패 결과** - 개인 성과 및 전체 순위
- **🔄 재시작 옵션** - 즉시 새 게임 시작
- **📊 통계 업데이트** - 개인 기록 갱신 및 저장

</details>

---

## 🖼️ 게임 스크린샷

<div align="center">

### 🏠 메인 화면
*깔끔하고 직관적인 메인 인터페이스*

![메인 화면](https://github.com/ChatHongPT/2024-JAVA-PROJECT/assets/129854575/c2f543f7-8e45-4a7c-a3c3-e3b3062d5a4f)

---

### ⚙️ 옵션 화면
*다양한 커스터마이징 옵션*

![옵션 화면](https://github.com/ChatHongPT/2024-JAVA-PROJECT/assets/129854575/38e11e2f-b510-4c6c-b84a-560e420a3622)

---

### 🏆 순위표 화면
*실시간 랭킹 시스템*

![순위표 화면](https://github.com/ChatHongPT/2024-JAVA-PROJECT/assets/129854575/76adb85c-01ea-420d-b0b2-33c772d0bcc2)

---

### 🎮 게임 화면
*흥미진진한 퀴즈 배틀*

![게임 화면](https://github.com/ChatHongPT/2024-JAVA-PROJECT/assets/129854575/efc38574-790f-4b27-a23c-b932ba84272a)

---

### 🏅 게임 결과 화면
*상세한 결과 분석*

![게임 결과 화면](https://github.com/ChatHongPT/2024-JAVA-PROJECT/assets/129854575/19fd36de-0b4c-4421-a2c1-2b0b2083a92b)

</div>

---

## 🚀 시작하기

### 📋 시스템 요구사항
- ☕ **Java 17** 이상
- 💾 **RAM**: 최소 512MB
- 💿 **저장공간**: 100MB 이상
- 🌐 **네트워크**: 인터넷 연결 필수

### ⚡ 빠른 설치
```bash
# 1. 저장소 클론
git clone https://github.com/ChatHongPT/2024-JAVA-PROJECT.git

# 2. 프로젝트 디렉토리로 이동
cd 2024-JAVA-PROJECT

# 3. 컴파일 및 실행
javac *.java
java MainGame
```

---

## 🎯 게임 플레이 가이드

### 🎮 게임 방법
1. **🚪 방 생성/입장** - 새 게임방을 만들거나 기존 방에 참여
2. **⏳ 대기** - 다른 플레이어들이 참여할 때까지 대기
3. **🎯 퀴즈 풀이** - 제시되는 넌센스 퀴즈를 빠르게 해결
4. **💬 소통** - 채팅을 통해 다른 플레이어들과 상호작용
5. **🏆 결과 확인** - 게임 종료 후 순위와 점수 확인

### 🏅 점수 시스템
- **✅ 정답**: +100점
- **⚡ 빠른 정답**: +50점 보너스
- **❌ 오답**: -10점
- **⏰ 시간 초과**: -5점

---

## 🤝 기여하기

프로젝트 개선에 참여하고 싶으시다면:

1. **🍴 Fork** 이 저장소를 포크하세요
2. **🌟 Feature** 브랜치를 생성하세요 (`git checkout -b feature/AmazingFeature`)
3. **💾 Commit** 변경사항을 커밋하세요 (`git commit -m 'Add some AmazingFeature'`)
4. **📤 Push** 브랜치에 푸시하세요 (`git push origin feature/AmazingFeature`)
5. **🔄 Pull Request**를 생성하세요

---

**⭐ 이 프로젝트가 마음에 드셨다면 Star를 눌러주세요! ⭐**

*Made with ❤️ by Team Nonsense*

</div>
