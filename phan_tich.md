1. Lỗi tính cân nặng số lẻ
Code hiện tại:
weightFee = 50000 + (Math.floor(weightKg - 1) * 10000);
Hệ thống đang dùng Math.floor() để làm tròn xuống.
Trong khi yêu cầu nghiệp vụ:
“Mỗi kg tiếp theo hoặc phân số của kg đều tính thêm 10.000”
Nhưng:
Math.floor(1.5 - 1) = 0
=> Không cộng thêm phí.

Lỗi ở ngưỡng khoảng cách 50km
Code hiện tại:
if (distanceKm < 10) {
distanceFee = 0;
} else if (distanceKm < 50) {
distanceFee = distanceKm * 5000;
} else {
distanceFee = distanceKm * 4000;
}
Vấn đề
Khoảng cách	Phí
49km	245000
50km	200000
Đi xa hơn nhưng phí lại giảm.
Nguyên nhân:
Khi đạt 50km, toàn bộ quãng đường bị chuyển sang mức:
4000/km