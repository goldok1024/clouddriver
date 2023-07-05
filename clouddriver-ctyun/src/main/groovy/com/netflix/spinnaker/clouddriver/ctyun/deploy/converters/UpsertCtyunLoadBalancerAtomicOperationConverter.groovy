package com.netflix.spinnaker.clouddriver.ctyun.deploy.converters

import com.netflix.spinnaker.clouddriver.orchestration.AtomicOperation
import com.netflix.spinnaker.clouddriver.orchestration.AtomicOperations
import com.netflix.spinnaker.clouddriver.security.AbstractAtomicOperationsCredentialsSupport
import com.netflix.spinnaker.clouddriver.ctyun.CtyunOperation
import com.netflix.spinnaker.clouddriver.ctyun.deploy.description.UpsertCtyunLoadBalancerDescription
import com.netflix.spinnaker.clouddriver.ctyun.deploy.ops.UpsertCtyunLoadBalancerAtomicOperation
import org.springframework.stereotype.Component


@CtyunOperation(AtomicOperations.UPSERT_LOAD_BALANCER)
@Component("upsertCtyunLoadBalancerDescription")
class UpsertCtyunLoadBalancerAtomicOperationConverter extends AbstractAtomicOperationsCredentialsSupport{
  AtomicOperation convertOperation(Map input) {
    new UpsertCtyunLoadBalancerAtomicOperation(convertDescription(input))
  }

  UpsertCtyunLoadBalancerDescription convertDescription(Map input) {
    CtyunAtomicOperationConverterHelper.convertDescription(input, this, UpsertCtyunLoadBalancerDescription)
  }
}
