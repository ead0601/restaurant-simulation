# Restaurant Simulation (Verilog-Style Heartbeat)

This project is a **Java-based simulation framework** inspired by Verilog/SystemC's event-driven model. It models a restaurant system using a **clock-driven evaluate/commit cycle** (heartbeat) with **waveform-style debugging** for state inspection.

---

## ✨ Features
- **Verilog-Style Heartbeat**: All simulation objects implement `SimProcess` with `evaluate()`, `commit()`, and `getState()` methods.
- **Waveform Debugging**: Built-in `WaveformViewer` displays state values per tick (like signal traces).
- **Minimal Tick Skeleton**: Each object (Restaurant, Cook, Customer, etc.) includes tick counters for easy debugging and waveform validation.
- **UML-Aligned**: Code structure mirrors the accompanying UML diagram and Object & Method Reference.
- **VSCode & Makefile Ready**: Supports easy compilation/running inside VSCode or via `make`.

---

## 📂 Project Structure
```
.
├── SimProcess.java          # Interface for tick-driven objects
├── SimulationClock.java     # Simulation clock (drives heartbeat)
├── HeartbeatManager.java    # Manages evaluate/commit stabilization
├── WaveformViewer.java      # Debug waveform state display
├── Restaurant.java          # Example simulation object (tick-driven)
├── Cook.java                # Additional tick-driven objects...
├── Customer.java
├── Server.java
├── Main.java                # Entry point: demo tick debug + full sim
├── Makefile                 # Simple build/run/clean workflow
└── docs/
    ├── UML.graphml          # UML diagram (yEd format)
    └── Object_Reference.docx # Object and Method Reference
```

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 11+ installed.
- (Optional) [yEd Graph Editor](https://www.yworks.com/products/yed) for UML.
- GNU Make (if using the provided Makefile).

### Build & Run
1. **Compile all Java files:**
   ```bash
   make
   ```
2. **Run the simulation:**
   ```bash
   make run
   ```
3. **Clean up compiled files:**
   ```bash
   make clean
   ```

### Running in VSCode
- Open the project folder in VSCode.
- Install the "Extension Pack for Java".
- Press `F5` or click **Run ▶** above `Main.java`.

---

## 🔧 Debug Mode (WaveformViewer)
The simulation includes a **waveform debug mode** to inspect state per tick:
```java
WaveformViewer wf = new WaveformViewer(hb, List.of(clock, restaurant, cook, customer, server));
wf.runDebug(50);  // runs 50 ticks and prints state
```

Sample output:
```
Time 1: [Clock: tickCounter=1] [Restaurant: tickCounter=1] ...
Time 2: [Clock: tickCounter=2] [Restaurant: tickCounter=2] ...
...
```

---

## 📘 Documentation
- **UML Diagram**: `docs/UML.graphml` (yEd-compatible)
- **Object Reference**: `docs/Object_Reference.docx`

---

## 🛠 Future Plans
- Expand tick logic to model realistic restaurant workflows.
- Integrate event-driven scheduling (e.g., customer arrivals).
- Export waveform traces to CSV for visualization in external tools.

---

## 📄 License
This project is released under the GPLv3 License. See `LICENSE` for details.

---

## 👤 Author
- **Your Name Here**  
  - GitHub: [ead0601](https://github.com/ead0601)
