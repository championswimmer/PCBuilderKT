package tech.arnav.pcbuilder.core

import tech.arnav.pcbuilder.core.systems.KVM
import tech.arnav.pcbuilder.core.systems.Peripheral
import tech.arnav.pcbuilder.core.systems.Tower
import java.lang.IllegalStateException

class PC private constructor(
    val tower: Tower,
    val kvm: KVM,
    val peripherals: List<Peripheral>
){

    class Builder {
        private var tower: Tower? = null
        private var kvm: KVM? = null
        private var peripherals = mutableListOf<Peripheral>()

        fun withTower(tower: Tower): Builder {
            this.tower = tower
            return this
        }
        fun withKVM(kvm: KVM): Builder {
            this.kvm = kvm
            return this
        }

        fun addPeripherals(vararg peripherals: Peripheral): Builder {
            this.peripherals.addAll(peripherals)
            return this
        }

        fun build(): PC {
            if (tower == null) throw IllegalStateException("PC cannot be built without a KVM (Keyboard + Video + Mouse)")
            if (kvm == null) throw IllegalStateException("PC cannot be built without the CPU tower")
            return PC(tower!!, kvm!!, peripherals);
        }

    }

}