# library — 图书管理系统（Git 多人协作教学仓库）

用一支视频里的场景做真实协作演示：三个人、三条分支、一次合并冲突、一次 rebase。

## 目录
- `application.yml`        配置（`max-borrow-days` 是冲突现场）
- `BorrowService.java`     借书（feature/borrow 分支开发）
- `ReturnService.java`     还书（直接在 main 上开发）
- `SeatService.java`       阅览座位（feature/seat 分支开发）

## 协作约定
1. `main` 受保护，只能通过 Pull Request 合并
2. 一人一分支：`feature/<功能>`，一天一推
3. 合并前先 `git rebase origin/main` 把冲突在自己分支里解决
4. 提交信息：`feat:` / `fix:` / `chore:` 开头，一句话说清做了什么
