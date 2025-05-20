Trong test là bản nâng cấp UI
Ver 2.1
✅ Model (model package)
Là nơi chứa dữ liệu và quy tắc xử lý nội tại

Không phụ thuộc vào giao diện

Gồm: Board, Cell, CellState, Player, Move

✅ View (ui package)
Giao diện người dùng

Nhận input (click chuột), hiển thị trạng thái

Gồm: BoardPanel, GameFrame, MessageBox, v.v.

✅ Controller (controller package)
Trung gian giữa Model và View

Nhận input từ View, cập nhật Model, gọi repaint

Gồm: GameController, GameLogic, hoặc MoveValidator nếu mở rộng

✅ Rule (rule package)

Logic của game, được game controller gọi ra để xử lý thông tin nhận được từ View 

