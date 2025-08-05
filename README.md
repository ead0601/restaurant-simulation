# Java Simulation Kernel Framework

This project provides a **reusable, general-purpose simulation framework** in Java, inspired by HDL simulators like Verilog/SystemC. 
It features a heartbeat-driven simulation loop, an integrated console for interactive debugging, GTKWave waveform logging, and single-step tick control.

---

## ✨ Features
- **Simulation Kernel (HeartbeatManager)**: Central engine managing evaluate/commit cycles for all entities.
- **Interactive Console**:
  - Inspect object state (`show` command).
  - Modify values at runtime (`set` command).
  - Single-step or run ticks (`tick` and `run` commands).
- **Waveform Logging (GTKWave Integration)**:
  - Export simulation state to `.vcd` files.
  - Visualize signals and object states over time in GTKWave.
- **Inheritance Model**:
  - `SimEntity` base class with built-in tick logic.
  - All simulation objects inherit from `SimEntity` for consistency.
- **Single-Step Debugging**:
  - Advance simulation one tick at a time for fine-grained analysis.
- **Modular and Reusable**:
  - Extendable to model restaurants, traffic systems, CPUs, robotics, or any discrete-time system.

---

## 📂 Project Structure
```
.
├── SimProcess.java              # Simulation process interface
├── SimEntity.java               # Base class for tick-driven entities
├── SimulationClock.java         # Clock entity with tick tracking
├── HeartbeatManager.java        # Simulation Kernel (console + waveform logging)
├── Main.java                    # Entry point
├── Entities:
│   ├── Restaurant.java
│   ├── Cook.java
│   ├── Customer.java
│   ├── Server.java
│   ├── Table.java
│   ├── ... (other entity classes)
└── docs/
    ├── UML.graphml              # UML diagram (yEd format)
    └── Object_Reference.docx     # Object and method documentation
```

---

## 🚀 Getting Started

### Prerequisites
- **Java JDK 11+**
- **GTKWave** (for waveform viewing): [https://gtkwave.sourceforge.net/](https://gtkwave.sourceforge.net/)

### Build & Run
1. Compile all Java files:
   ```bash
   make
   ```
2. Run the simulation kernel:
   ```bash
   make run
   ```
3. You'll see the simulation prompt:
   ```
   sim>
   ```

---

## 🖥 Console Commands
- `help` → Show all commands.
- `list` → List all registered simulation objects.
- `show <object>` → Display the state of an object.
- `set <object> <field> <value>` → Modify an object's field at runtime.
- `tick [N]` → Advance simulation by N ticks (default: 1).
- `run <N>` → Run simulation for N ticks continuously.
- `log start <filename>` → Start waveform logging to `<filename>.vcd`.
- `log stop` → Stop waveform logging.
- `quit` → Exit the simulation console.

---

## 📊 Waveform Logging (GTKWave Integration)
1. Start waveform logging from the console:
   ```
   sim> log start simulation.vcd
   sim> run 100
   sim> log stop
   ```
2. Open the generated VCD file in GTKWave:
   ```bash
   gtkwave simulation.vcd
   ```
3. Analyze tick-by-tick state changes for all objects.

---

## 🔧 Extending the Framework
- Add new simulation objects by extending `SimEntity` and overriding `getState()`.
- Register them with the kernel using `hb.registerProcess(...)`.
- Console and waveform logging automatically include all registered entities.

---

## 🛠 Future Enhancements
- **Breakpoints & Watchpoints** (e.g., stop when a variable changes).
- **Event-driven scheduling** for asynchronous events.
- **State save/load** for checkpointing and rollback.
- **Conditional triggers** (e.g., auto-log or pause on specific conditions).

---

## 📘 Documentation
- **UML Diagram**: `docs/UML.graphml` (open with yEd).
- **Object Reference**: `docs/Object_Reference.docx` (full attributes & methods).

---

## 📄 License
GPLv3 License.

---

## 👤 Author
- Edward Diaz  
  GitHub: [ead0601](https://github.com/ead0601)
