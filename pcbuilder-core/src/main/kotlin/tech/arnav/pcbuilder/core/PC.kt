package tech.arnav.pcbuilder.core

import tech.arnav.pcbuilder.core.components.KVM
import tech.arnav.pcbuilder.core.components.Peripheral
import tech.arnav.pcbuilder.core.components.Tower
import java.lang.IllegalStateException

class PC {

    lateinit var tower: Tower
    lateinit var kvm: KVM
    private lateinit var _peripherals: MutableList<Peripheral>
    val peripherals: List<Peripheral> get() = _peripherals

    class Builder {
        private val pc = PC()

        fun withTower(tower: Tower): Builder {
            pc.tower = tower
            return this
        }
        fun withKVM(kvm: KVM): Builder {
            pc.kvm = kvm
            return this
        }

        fun addPeripherals(vararg peripherals: Peripheral): Builder {
            if (!pc::_peripherals.isInitialized) pc._peripherals = arrayListOf()
            pc._peripherals.addAll(peripherals)
            return this
        }

        fun build(): PC {
            if (!pc::kvm.isInitialized) throw IllegalStateException("PC cannot be built without a KVM (Keyboard + Video + Mouse)")
            if (!pc::tower.isInitialized) throw IllegalStateException("PC cannot be built without the CPU tower")
            return pc;
        }

    }

}