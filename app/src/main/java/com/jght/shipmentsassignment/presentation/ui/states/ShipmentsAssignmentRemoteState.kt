package com.jght.shipmentsassignment.presentation.ui.states

sealed class ShipmentsAssignmentRemoteState {
    object Loading: ShipmentsAssignmentRemoteState()
    object Success: ShipmentsAssignmentRemoteState()
    object Error : ShipmentsAssignmentRemoteState()
}