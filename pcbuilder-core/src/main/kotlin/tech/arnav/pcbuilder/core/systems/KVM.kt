package tech.arnav.pcbuilder.core.systems

import tech.arnav.pcbuilder.core.peripherals.Display
import tech.arnav.pcbuilder.core.peripherals.Keyboard
import tech.arnav.pcbuilder.core.peripherals.Mouse
import java.lang.IllegalStateException

class KVM private constructor(
    val keyboard: Keyboard,
    val display: Display,
    val mouse: Mouse?
) {


    class Builder {
        private var keyboard: Keyboard? = null
        private var display: Display? = null
        private var mouse: Mouse? = null

        fun withKeyboard(keyboard: Keyboard): Builder {
            this.keyboard = keyboard
            return this
        }

        fun withDisplay(display: Display): Builder {
            this.display = display
            return this
        }

        fun withMouse(mouse: Mouse): Builder {
            this.mouse = mouse
            return this
        }

        fun build(): KVM {
            if (keyboard == null) throw IllegalStateException("A KVM unit must have a keyboard")
            if (display == null) throw IllegalStateException("A KVM unit must have a display")
            return KVM(keyboard!!, display!!, mouse)
        }

    }
}