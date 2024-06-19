package autocomplete;

import java.util.List;
import org.junit.jupiter.api.Test;

class AutoCompletionManagerTest {

    private final AutoCompletionManager autoCompletionManager = AutoCompletionManager.useMemory();

    List<String> l = List.of("스마트폰 케이스", "무선 이어폰", "전기면도기", "블루투스 스피커", "휴대용 충전기", "스마트워치", "디지털 손목 시계", "유기농 샴푸", "카메라 드론", "스마트 LED 조명", "보온 텀블러", "전기차 충전기", "핸드폰 홀더", "휴대용 스팀 다리미", "휴대용 가습기", "칼세트", "수면 마스크", "헬스 트레킹 슈즈", "캠핑 텐트", "야외용 가구 세트", "바디 블러셔", "화장품 세트", "보습 핸드크림", "다이어트 보조제", "헤어 드라이기",
            "바디 보드", "수영 경력 수영복", "스키 장비", "등산 모자", "야외 라이프재킷", "야외 아기 유모차", "화이트 골프 공", "야외용 스포츠 구스", "골프 클럽 세트", "자전거 안전 장비", "자전거 헬멧", "캠핑 용품", "스노클링 장비", "피크닉 매트", "휴대용 캠핑 스토브", "휴대용 태양광 충전기", "보트 보트", "서핑 보드", "다이어트 식품 세트", "요가 매트", "운동용 손목 보호대", "헬스 클럽 멤버십", "필라테스 볼", "스포츠 드라이브 스루",
            "자전거 고급 잠금장치", "휴대용 라디오", "골프용 GPS 시계", "낚시 장비 세트", "수영 고글", "스케이트보드", "보호용 스쿠터 헬멧", "서핑 슈트", "캠핑용 식기 세트", "야외 바비큐 그릴", "야구 글러브", "배드민턴 라켓 세트", "테니스 공", "탁구 테이블", "등산용 물병", "자전거 라이트", "체력 단련용 운동기구", "야외 사진기", "낚시 로드", "스포츠 안전 조끼", "자동차 세차 용품", "자동차 차량용 가전 제품", "평생 구독 플랜", "장난감 공예",
            "DIY 가구 제작 키트", "포장된 펫 음식", "펫 침대", "펫 장난감 세트", "전기 자동차 충전기", "핸드폰 블루투스 이어폰", "스마트 LED 조명", "휴대용 보온 텀블러", "디지털 무선 도어락", "휴대용 스팀 다리미", "무선 충전 패드", "유기농 헤어 샴푸", "카메라 드론", "휴대용 가습기", "전기 면도기", "헬스 트레킹 슈즈", "캠핑 텐트", "야외용 가구 세트", "화장품 세트", "보습 핸드크림", "다이어트 보조제", "헤어 드라이기", "바디 보드",
            "수영 경력 수영복", "스키 장비", "등산 모자", "야외 라이프재킷", "여성용 여름 원피스", "남성용 캐주얼 셔츠", "아동용 운동화", "스마트폰 케이스", "무선 이어폰", "노트북 컴퓨터", "블루투스 스피커", "가죽 지갑", "여성용 핸드백", "선글라스", "스포츠 워치", "헤어 드라이어", "전기 면도기", "커피 머신", "전자레인지", "휴대용 충전기", "디지털 카메라", "LED TV", "에어 프라이어", "진공 청소기", "전기 주전자", "요가 매트", "캠핑 텐트",
            "피트니스 트래커", "러닝화", "자전거", "헬멧", "등산화", "낚시대", "골프채 세트", "테니스 라켓", "수영복", "스키 장비", "모터사이클 재킷", "자동차 네비게이션", "차량용 공기청정기", "주방용 칼 세트", "압력솥", "식기세척기", "냉장고", "세탁기", "건조기", "가습기", "공기청정기", "전기 담요", "모니터", "키보드", "마우스", "프린터", "스캐너", "외장 하드 드라이브", "USB 메모리", "게임 콘솔", "게임 패드", "헤드셋", "웹캠",
            "그래픽 카드", "메모리 카드", "스마트 워치", "태블릿", "전자책 리더", "키친 타월", "화장지", "세탁 세제", "섬유 유연제", "주방 세제", "손 세정제", "샴푸", "컨디셔너", "바디 워시", "페이셜 클렌저", "페이셜 토너", "로션", "크림", "선크림", "메이크업 리무버", "립스틱", "아이섀도우", "마스카라", "파운데이션", "블러셔", "네일 폴리쉬", "향수", "면도 크림", "손톱깎이", "면봉", "화장솜", "여성용 위생용품", "남성용 탈취제",
            "여성용 탈취제", "베이비 로션", "베이비 샴푸", "기저귀", "유모차", "아기 침대", "아기 의자", "아기 젖병", "아기 이유식", "아기 장난감", "어린이 책", "야외 아기 유모차", "화이트 골프 공", "야외용 스포츠 구스", "골프 클럽 세트", "자전거 안전 장비", "자전거 헬멧", "캠핑 용품", "스노클링 장비", "피크닉 매트", "휴대용 캠핑 스토브", "휴대용 태양광 충전기", "보트 보트", "서핑 보드", "자동차 용 고급 터보", "사전 훈련된 자동차",
            "자동차 청소 용품", "인공 양식 포장");

    @Test
    void a() {
        autoCompletionManager.save(l);

        System.out.println("l.size() = " + l.size());

        List<String> strings = autoCompletionManager.find("리");
        System.out.println("strings = " + strings);
    }

}
